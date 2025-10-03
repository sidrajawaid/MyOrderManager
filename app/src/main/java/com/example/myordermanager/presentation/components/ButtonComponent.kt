package com.example.myordermanager.presentation.components

import android.content.Context
import com.example.myordermanager.R
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption


@Composable
fun LargeFilledButton(context: Context,buttonText:String, onClick:(String)->Unit) {

    FilledIconButton (onClick = {onClick(context.getString(R.string.api_key))},
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            //.border(border = BorderStroke(2.dp, Color.Gray))
           // .padding(8.dp),
,
        shape = RoundedCornerShape(6.dp),
       /* elevation =  ButtonDefaults.buttonElevation(
            defaultElevation = 88.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp
        )*/) {
        Text(buttonText, fontStyle = FontStyle.Normal, fontWeight = FontWeight.W600, fontSize = 18.sp )
    }


}

@Composable
fun LargeOutlinedButton(buttonText:String) {

    OutlinedIconButton(
        onClick = {/*TODO()*/ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(26.dp)
            .border(border = BorderStroke(2.dp, Color.Gray))
            .background(Color.Black),
        shape = RoundedCornerShape(4.dp),
        /*elevation =  ButtonDefaults.buttonElevation(
            defaultElevation = 18.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp
        )*/
    ) {
        Text(buttonText)
    }


}

@Composable
fun SmallFilledButton(buttonText:String) {

    FilledTonalButton (onClick = {/*TODO()*/},
        modifier = Modifier
            .fillMaxWidth()
            .padding(26.dp)
            .border(border = BorderStroke(2.dp, Color.Gray))
            .background(Color.Black),
        shape = RoundedCornerShape(4.dp),
        elevation =  ButtonDefaults.buttonElevation(
            defaultElevation = 18.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp
        )) {
        Text(buttonText)
    }


}

@Composable
fun SmallOutlinedButton(buttonText:String) {

    OutlinedIconButton (onClick = {/*TODO()*/},
        modifier = Modifier
            .fillMaxWidth()
            .padding(26.dp)
            .border(border = BorderStroke(2.dp, Color.Gray))
            .background(Color.Black),
        shape = RoundedCornerShape(4.dp),
    ){
        Text(buttonText)
    }


}

@Composable
@Preview
fun  previewButton(){
//LargeFilledButton("men fn n")

}