package com.example.myordermanager.presentation.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun OutlinedTextFieldComponent(
    isEnabled: Boolean, isReadOnly: Boolean, isErr: Boolean, isSingleLine: Boolean,
    maxLines: Int,hint:String,  edtLabel: String, options: KeyboardOptions
){

    var text by remember { mutableStateOf(TextFieldValue("") )}


    OutlinedTextField(
        value = text,
        onValueChange = { newText -> text = newText },
        label = { Text(edtLabel) },
        placeholder = { Text(hint)
        },
        enabled = isEnabled,
        readOnly = isReadOnly,
        isError = isErr,
        modifier = Modifier.padding(8.dp)
            .background(color = Color.White)
            .fillMaxWidth(),
        singleLine = isSingleLine,
        maxLines = maxLines,
        keyboardOptions = options
    )

}