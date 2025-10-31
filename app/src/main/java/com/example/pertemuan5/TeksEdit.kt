package com.example.pertemuan5

import android.widget.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun FormDataDiri(modifier: Modifier){
   Column(modifier = Modifier.fillMaxSize().background(color = colorResource(R.color.purple_500))) {
       var textNama by remember { mutableStateOf(value = "") }
       var textAlamat by remember { mutableStateOf(value = "") }
       var textJk by remember { mutableStateOf(value = "") }

       var nama by remember { mutableStateOf(value = "") }
       var alamat by remember { mutableStateOf(value = "") }
       var jk by remember { mutableStateOf(value = "") }

       val gender: List<String> = listOf("Laki-laki", "Perempuan")

       Column(
           modifier = Modifier
               .padding(top = 50.dp),
           verticalArrangement = Arrangement.Top,
           horizontalAlignment = Alignment.CenterHorizontally,
       ){
           OutlinedTextField(
               value = textNama,
               singleLine = true,
               shape = MaterialTheme.shapes.large,
               modifier = Modifier.width(width = 250.dp),
               label = { Text(text = "Nama Lengkap", color = Color.White) },
               onValueChange = {
                   textNama = it
               }
           )
           Row {
               gender.forEach { item ->
                   Row(
                       modifier = Modifier
                           .selectable(
                               selected = textJk == item,
                               onClick = {
                                   textJk = item
                               }
                           ),
                       verticalAlignment = Alignment.CenterVertically) {
                       RadioButton(
                           selected = textJk == item,
                           onClick = {
                               textJk = item
                           })
                       Text(text = item, color = Color.White)
                   }
               }
           }
           OutlinedTextField(
               value = textAlamat,
               singleLine = true,
               modifier = Modifier.width(width = 250.dp),
               label = {
                   Text(text = "Alamat Lengkap", color = Color.White)
               },
               onValueChange = {
                   textAlamat = it
               }
           )
           HorizontalDivider(
               modifier = Modifier.padding(
                   bottom = dimensionResource(R.dimen.padding_medium),
                   top = dimensionResource(id = R.dimen.padding_medium)
               ),
               thickness = dimensionResource(id = R.dimen.divider_tipis),
               color = Color.Black
           )
           Button(
               modifier = Modifier.fillMaxWidth(),
               enabled = textAlamat.isNotEmpty(),
               onClick = {
                   nama = textNama
                   alamat = textAlamat
                   jk = textJk
               }) {
               Text(text = stringResource(id = R.string.submit))
           }
           HorizontalDivider(
               modifier = Modifier.padding(
                   bottom = dimensionResource(R.dimen.padding_medium),
                   top = dimensionResource(id = R.dimen.padding_medium)
               ),
               thickness = dimensionResource(id = R.dimen.divider_tipis),
               color = Color.Black
           )
           ElevatedCard(
               elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
               colors = CardDefaults.cardColors(containerColor = Color.White),
               modifier = Modifier.height(100.dp).width(300.dp)
           ) {
