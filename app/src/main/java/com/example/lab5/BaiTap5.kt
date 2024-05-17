package com.example.lab5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

class BaiTap5 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PaymentScreen()
        }
    }

    @Composable
    fun PaymentScreen() {
        var selectedOption by remember { mutableStateOf("") }
        val paymentMethods = listOf(
            "PayPal" to "https://upload.wikimedia.org/wikipedia/commons/thumb/3/39/PayPal_logo.svg/1024px-PayPal_logo.svg.png",
            "VISA" to "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/Visa_Inc._logo.svg/2560px-Visa_Inc._logo.svg.png",
            "Momo" to "https://upload.wikimedia.org/wikipedia/vi/f/fe/MoMo_Logo.png",
            "Zalo Pay" to "https://cdn.haitrieu.com/wp-content/uploads/2022/10/Logo-ZaloPay-Square.png",
            "Thanh toán trực tiếp" to "https://luathongbang.com.vn/wp-content/uploads/2021/12/thanh-toan-tien-mat-e1573618010533.jpg"
        )

        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFFF3F0))
                .padding(16.dp)
        ) {
            Text(
                text = "Thanh Toán",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier
                    .background(Color.Black, RoundedCornerShape(8.dp))
                    .padding(16.dp)
            ) {
                Text(
                    text = "Địa chỉ nhận hàng",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Hùng | Báo Đáp \n Trấn Yên \n Yên Bái",
                        color = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Vui lòng chọn một trong những phương thức sau:",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(16.dp))

            paymentMethods.forEach { (method, icon) ->
                GetRowItem(
                    color = when (method) {
                        "PayPal" -> Color.Yellow
                        "VISA" -> Color.Cyan
                        "Momo" -> Color.Magenta
                        "Zalo Pay" -> Color.Green
                        else -> Color.Gray
                    },
                    linkImage = icon,
                    noidungtext = method,
                    selected = selectedOption == method,
                    onClick = { selectedOption = method }
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { /* Handle tiếp theo */ },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
            ) {
                Text(
                    text = "Tiếp theo",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }

    @Composable
    fun GetRowItem(
        color: Color,
        linkImage: String,
        noidungtext: String,
        selected: Boolean,
        onClick: () -> Unit
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(5.dp)
                .background(color = color, shape = RoundedCornerShape(15.dp))
                .height(50.dp)
                .fillMaxWidth()
                .clickable { onClick() }
        ) {

            AsyncImage(
                model = linkImage,
                modifier = Modifier
                    .width(60.dp)
                    .padding(5.dp),
                contentDescription = null
            )

            Text(
                text = noidungtext,
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp, 0.dp, 0.dp, 0.dp),
                color = Color.White
            )

            RadioButton(selected = selected, onClick = onClick)
        }
    }

    @Composable
    fun GetTextTitle(title: String) {
        Text(
            text = title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            fontSize = 30.sp,
            color = Color.Red,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        PaymentScreen()
    }
}
