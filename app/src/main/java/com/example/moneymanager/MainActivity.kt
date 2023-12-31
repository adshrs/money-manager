package com.example.moneymanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.material3.icons.Icons
import androidx.compose.material3.icons.filled.Lock
import androidx.compose.material3.icons.filled.Person
import androidx.compose.material3.icons.filled.Visibility
import androidx.compose.material3.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.platform.LocalWindowManager
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.featherandroidtasks.ui.theme.FeatherAndroidTasksTheme
import com.example.featherandroidtasks.ui.theme.Shapes
import com.example.featherandroidtasks.ui.theme.Teal200

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(onLoginClicked: (String, String) -> Unit) {
	var username by remember { mutableStateOf("") }
	var password by remember { mutableStateOf("") }
	var isPasswordVisible by remember { mutableStateOf(false) }

	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(16.dp)
	) {
		// Logo or Image
		Image(
			painter = painterResource(id = R.drawable.ic_launcher_foreground),
			contentDescription = null,
			modifier = Modifier
				.size(120.dp)
				.clip(shape = Shapes.medium)
				.background(MaterialTheme.colorScheme.primary)
		)

		Spacer(modifier = Modifier.height(16.dp))

		// Username TextField
		TextField(
			value = username,
			onValueChange = { username = it },
			modifier = Modifier
				.fillMaxWidth()
				.padding(8.dp),
			leadingIcon = {
				Icon(imageVector = Icons.Default.Person, contentDescription = null)
			},
			placeholder = { Text(text = "Username") },
			singleLine = true
		)

		// Password TextField
		var passwordVisibility by remember { mutableStateOf(false) }
		TextField(
			value = password,
			onValueChange = { password = it },
			modifier = Modifier
				.fillMaxWidth()
				.padding(8.dp),
			leadingIcon = {
				Icon(imageVector = Icons.Default.Lock, contentDescription = null)
			},
			placeholder = { Text(text = "Password") },
			singleLine = true,
			visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
			trailingIcon = {
				val image = if (passwordVisibility) Icons.Default.VisibilityOff else Icons.Default.Visibility
				IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
					Icon(imageVector = image, contentDescription = null)
				}
			}
		)

		Spacer(modifier = Modifier.height(16.dp))

		// Login Button
		Button(
			onClick = { onLoginClicked(username, password) },
			modifier = Modifier
				.fillMaxWidth()
				.height(48.dp)
		) {
			Text(text = "Login")
		}
	}
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
	FeatherAndroidTasksTheme {
		LoginScreen(onLoginClicked = { _, _ -> })
	}
}
