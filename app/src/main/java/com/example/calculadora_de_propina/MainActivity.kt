package com.example.calculadora_de_propina

import android.R.attr.label
import android.R.attr.value
import android.graphics.drawable.Icon
import android.icu.text.NumberFormat
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation.Companion.keyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.NotificationCompat
import androidx.test.espresso.base.Default
import com.example.compose.Calculadora_De_PropinaTheme
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Calculadora_De_PropinaTheme {
                TimeLayout()
            }
        }
    }
}

@Composable
fun TimeLayout(modifier: Modifier = Modifier){

    var amountInput by rememberSaveable { mutableStateOf("") }

    val amount = amountInput.toDoubleOrNull()?: 0.0

    var tip_Input by rememberSaveable { mutableStateOf("") }

    var tipPercent = tip_Input.toDoubleOrNull()?:0.0




    var  roundUp by rememberSaveable { mutableStateOf(false) }

    val tip = calculeTip(amount, tipPercent, roundUp   )



    Column(modifier = modifier

        .statusBarsPadding()
        .padding(horizontal = 40.dp)
        .verticalScroll(rememberScrollState())
        .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)

    {
        Text(text = stringResource(R.string.calculate_tip),
            modifier = modifier.padding( bottom = 16.dp, end = 185.dp)
        )

        EditNumberField(
            label = R.string.bill_amount,

            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next),

            value = amountInput,
            onValueChange = {amountInput = it},
            leadingIcon = R.drawable.money,
            modifier = modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth())

        // porcentaje personalizado

        EditNumberField(
            label = R.string.how_was_the_service,

            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done),

            value = tip_Input,
            onValueChange = {tip_Input = it},
            leadingIcon = R.drawable.percent,
            modifier = modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth())



        //  Switch
        RoundTheTipRow(
            roundUp= roundUp,
            onRoundUpChanged = {roundUp= it},
        )



        Spacer(modifier=modifier.height(32.dp))

        Text(text = stringResource(R.string.tip_amount, tip),
            style = MaterialTheme.typography.displaySmall)

        Spacer(modifier=modifier.height(16.dp))


    }

}

private fun calculeTip (
    amount: Double,
    tipPercent: Double = 15.0,
    roundUp: Boolean= false): String {


    var tip1 = amount * ((tipPercent)/100)
    if (roundUp){
        tip1 = kotlin.math.ceil(tip1)

    }
    return NumberFormat.getCurrencyInstance().format(tip1)
}

@Composable
fun EditNumberField(
    @DrawableRes leadingIcon: Int,
    @StringRes label: Int,
    keyboardOptions: KeyboardOptions,
    value:String,
    onValueChange: (String)-> Unit,
    modifier: Modifier = Modifier) {


    TextField(
        value = value,
        onValueChange = onValueChange ,
        label = {Text(text = stringResource(label))},
        leadingIcon = { Icon(painter = painterResource(id = leadingIcon), null,) },
        singleLine = true,
        keyboardOptions = keyboardOptions,
        modifier = modifier
    )





}

@Composable
fun RoundTheTipRow(roundUp: Boolean,
                   onRoundUpChanged:( Boolean)-> Unit,
                   modifier: Modifier = Modifier){

    Row (modifier = modifier.fillMaxWidth()
        .size(48.dp),
        Arrangement.End){

        Switch(modifier=modifier
            .wrapContentWidth(Alignment.End),
            checked = roundUp,
            onCheckedChange = onRoundUpChanged ,


            )
    }




}

@Preview (showBackground = true)
@Composable
fun TimeLayoutPreview(){
    Calculadora_De_PropinaTheme() {
        TimeLayout()
    }

}