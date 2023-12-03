package com.valentyuk.app_one

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listView = findViewById<ListView>(R.id.listView)
        val userData: EditText = findViewById(R.id.user_data)
        val button: Button = findViewById(R.id.button)
        //базавая конструкция для работы со списком
        val todos: MutableList<String> = mutableListOf() //1. пустой массив (список) создаем
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, todos)//2. создаем пустой адаптер на основе  ArrayAdapter и используем  контекст с которым мы работаем и дизайн для каждого элемента (используем встроенный)
        listView.adapter=adapter//3.обращаемся к адаптеру
        listView.setOnItemClickListener { adapterview, view, i, l ->  //параметр i- позития элемента на который мы нажали
            val text = listView.getItemAtPosition(i).toString()//находим элемент, преобразуем в строку
            adapter.remove(text)//удаляем его
            Toast.makeText(this, "Мы удалили: $text", Toast.LENGTH_LONG).show()//выводим сообщение об удалении текста
        }
        button.setOnClickListener {
            val text = userData.text.toString().trim()
            if (text !="")
                adapter.insert(text, 0)//текст введенный пользователем, будет каждый раз добавляться в начало списка


        }
    }
}