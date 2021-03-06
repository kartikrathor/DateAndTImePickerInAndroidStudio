package com.example.promaticsindia

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.NumberPicker
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var month = arrayOf<String>("Jan", "Feb", "March", "April", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec")
        var str = arrayOf<String>("PM", "AM")


        //date

        datePickerMin.minValue = 1
        datePickerMin.maxValue = 31

        monthPickerMin.minValue = 0
        monthPickerMin.maxValue = (month.size - 1)

        yearPickerMin.minValue = 1990
        yearPickerMin.maxValue = 2021

        var dateVal = 1
        var monthVal = 1
        var yearVal = 1990
        var monthStr = "Jan"

        monthPickerMin.displayedValues = month

        datePickerMin.setOnValueChangedListener { numberPicker: NumberPicker, i: Int, i1: Int ->

            dateVal = datePickerMin.value

        }

        monthPickerMin.setOnValueChangedListener { numberPicker: NumberPicker, i: Int, i1: Int ->

            val j = numberPicker.value
            monthStr = month[j]

        }

        yearPickerMin.setOnValueChangedListener { numberPicker: NumberPicker, i: Int, i1: Int ->

            yearVal = numberPicker.value

        }
        //time
        numberPickerMin.minValue = 0
        numberPickerMin.maxValue = 12


        numberPickerSec.minValue = 0
        numberPickerSec.maxValue = 59

        numberPickerAm.minValue = 0
        numberPickerAm.maxValue = (str.size - 1)

        var min = 0
        var sec = 0
        var amOrPm = "PM"


        //for am or pm

        numberPickerAm.displayedValues = str

        numberPickerMin.setOnValueChangedListener { numberpicker, i, i2 ->

            min = numberpicker.value
        }


        numberPickerMin.setOnValueChangedListener { numberpicker, i, i2 ->

            min = numberpicker.value
        }
        numberPickerSec.setOnValueChangedListener { numberPickerSec, i, i2 ->
            sec = numberPickerSec.value

        }
        numberPickerAm.setOnValueChangedListener { numberPicker: NumberPicker, i: Int, i1: Int ->

            val i = numberPicker.value
            amOrPm = str[i]

        }

        btnGetValue.setOnClickListener {

            showTime.text = "$min : $sec : $amOrPm"
            showDate.text = "$dateVal / $monthStr / $yearVal"
        }


        //calender

        val c = Calendar.getInstance()
        val calYear = c.get(Calendar.YEAR)
        val calMonth = c.get(Calendar.MONTH)
        val calDay = c.get(Calendar.DAY_OF_MONTH)



        btnCalender.setOnClickListener {

            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->

                showCalender.setText("$dayOfMonth / $month / $year")
            }, calYear, calMonth, calDay)

            dpd.show()


        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        var selectedText = ""


        val id =item.itemId

        if(id == R.id.RecycleViewMenu){

            val intent = Intent(this, RecycleViewActivity::class.java)
            this.startActivity(intent)
            selectedText = "RecycleView"
            return true
        }

        if (id == R.id.DateAndTimeMenu){

            val intent = Intent(this, RecycleViewActivity::class.java)
            this.startActivity(intent)
            selectedText="DateAndTime"
            return true
        }


        if (id == R.id.alertMenu){

            val intent = Intent(this, AlertMenuActivity::class.java)
            this.startActivity(intent)
            selectedText ="alertMenu"
            return true
        }



        Toast.makeText(applicationContext,selectedText,Toast.LENGTH_LONG).show()

        return super.onOptionsItemSelected(item)
    }




}
