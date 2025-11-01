package com.example.pertemuan5

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormRegistrasi(modifier: Modifier) {
    Box {
        var textNama by remember { mutableStateOf(value = "") }
        var textAsal by remember { mutableStateOf(value = "") }
        var textRT by remember { mutableStateOf(value = "") }
        var textRW by remember { mutableStateOf(value = "") }
        var textUmur by remember { mutableStateOf(value = "") }
        var textTanggal by remember { mutableStateOf(value = "") }
        var textJk by remember { mutableStateOf(value = "") }

        var nama by remember { mutableStateOf(value = "") }
        var asal by remember { mutableStateOf(value = "") }
        var rt by remember { mutableStateOf(value = "") }
        var rw by remember { mutableStateOf(value = "") }
        var umur by remember { mutableStateOf(value = "") }
        var tanggal by remember { mutableStateOf(value = "") }
        var jk by remember { mutableStateOf(value = "") }

        var showDialog by remember { mutableStateOf(false) }
        if (showDialog) {
            androidx.compose.material3.AlertDialog(
                onDismissRequest = { showDialog = false },
                title = {
                    Text(
                        text = "Berhasil",
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                },
                text = {
                    Column {
                        Text("Nama: $textNama")
                        Text("Asal Kota: $textAsal")
                        Text("Tanggal Lahir: ${textTanggal}")
                        Text("RT: $textRT")
                        Text("RW: $textRW")
                        Text("Umur: $textUmur")
                        Text("Jenis Kelamin: $textJk")
                    }
                },
                confirmButton = {
                    Button(onClick = { showDialog = false }) {
                        Text("OK")
                    }
                }
            )
        }

        val gender: List<String> = listOf("Laki-laki", "Perempuan")
        val validasi = remember { mutableStateOf(false) }
        var showDatePicker by remember { mutableStateOf(false) }
        val datePickerState = rememberDatePickerState()
        val selectedDate = datePickerState.selectedDateMillis?.let {
            convertMillisToDate(it)
        } ?: ""



        LaunchedEffect(key1 = datePickerState.selectedDateMillis) {
            datePickerState.selectedDateMillis?.let { millis ->
                textTanggal = convertMillisToDate(millis)
            }
        }

        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.bgbiru),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Text(
            text = stringResource(id = R.string.registrasi),
            fontSize = 30.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier.padding(top = 60.dp, start = 100.dp)
        )
        Card(
            modifier = Modifier.padding(top = 120.dp, start = 20.dp, end = 20.dp).fillMaxWidth()
                .height(height = 680.dp),
            shape = MaterialTheme.shapes.extraLarge,
            colors = CardDefaults.cardColors(
                containerColor = Color.White.copy(
                    alpha = 0.4f
                )
            ),
        ) {
            Column(
                modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
            ) {
                OutlinedTextField(
                    value = textNama,
                    singleLine = true,
                    shape = MaterialTheme.shapes.extraLarge,
                    modifier = Modifier.width(width = 320.dp).padding(top = 50.dp),
                    label = { Text(text = "Nama Lengkap", color = Color.White) },
                    onValueChange = {
                        textNama = it
                    }
                )
                OutlinedTextField(
                    value = textAsal,
                    singleLine = true,
                    shape = MaterialTheme.shapes.extraLarge,
                    modifier = Modifier.width(width = 320.dp).padding(top = 20.dp),
                    label = { Text(text = "Kota Asal", color = Color.White) },
                    onValueChange = {
                        textAsal = it
                    }
                )




