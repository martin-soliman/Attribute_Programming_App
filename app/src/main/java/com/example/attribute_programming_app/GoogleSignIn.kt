package com.example.attribute_programming_app


import android.content.ContentValues.TAG
import android.credentials.GetCredentialException
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import androidx.navigation.NavController
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException
import kotlinx.coroutines.launch
import java.security.MessageDigest
import java.util.UUID
import android.content.Context
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@Composable
fun GoogleSignInButton(navController: NavController) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    val onClick: () -> Unit = {
        val credentialManager = CredentialManager.create(context)

        val rawNonce = UUID.randomUUID().toString()
        val bytes = rawNonce.toByteArray()
        val md = MessageDigest.getInstance("SHA-256")
        val digest = md.digest(bytes)
        val hashedNonce = digest.fold("") {str, it -> str + "%02x".format(it)}

        val googleIdOption: GetGoogleIdOption = GetGoogleIdOption.Builder()
            .setFilterByAuthorizedAccounts(false)
            .setServerClientId("449101684383-k9sifvrfnfrt9fpvqucv3acql76fubo2.apps.googleusercontent.com")
            .setNonce(hashedNonce)
            .build()

        val request: GetCredentialRequest = GetCredentialRequest.Builder()
            .addCredentialOption(googleIdOption)
            .build()

        coroutineScope.launch{
            try {
                val result = credentialManager.getCredential(
                    request = request,
                    context = context,
                )
                val credential = result.credential

                val googleIdTokenCredential = GoogleIdTokenCredential
                    .createFrom(credential.data)

                val googleIdToken = googleIdTokenCredential.idToken
                Log.i(TAG, googleIdToken)

                //navigate to serial num page if successful
                navController.navigate(Screen.SerialNumScreen.route)

                Toast.makeText(context, "You are signed in!", Toast.LENGTH_LONG).show()
            }catch(e: GetCredentialException) {
                Toast.makeText(context, e.message, Toast.LENGTH_LONG).show()
            }
            catch(e: GoogleIdTokenParsingException) {
            }
        }
    }

    val orange = 0xFFFFA500
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(Color(orange)),
        ){
        Text("Sign in with Wrmth Gmail")
    }
}

fun promptUserForEmail(
    context: Context,
    allowedDomains: List<String>,
    onEmailEntered: (String) -> Unit,
    onInvalidDomain: () -> Unit
) {
    val editText = EditText(context)
    editText.hint = "Enter your email"

    val dialog = AlertDialog.Builder(context)
        .setTitle("Enter Email")
        .setView(editText)
        .setPositiveButton("OK") { _, _ ->
            val email = editText.text.toString()
            val domain = email.substringAfterLast('@') // Extract domain from email

            if (allowedDomains.contains(domain)) {
                onEmailEntered(email)
            } else {
                onInvalidDomain()
            }
        }
        .setNegativeButton("Cancel", null)
        .create()

    dialog.show()
}