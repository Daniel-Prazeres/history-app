package com.example.historyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Button
import android.widget.ImageView
import androidx.core.text.trimmedLength

var hello :String = "hello"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Variables
        val etNum :EditText = findViewById(R.id.etTextEnterNumber)
        val btnGenerate :Button = findViewById(R.id.btnGenerateHistory)
        val btnClear :Button = findViewById(R.id.btnClear)
        val tvDisplay :TextView = findViewById(R.id.tvDisplay)
        val imgWarning :ImageView = findViewById(R.id.imgWarning)
        val strWarning1 :TextView = findViewById(R.id.strWarning1)
        val strWarning2 :TextView = findViewById(R.id.strWarning2)
        val arrAge = arrayOf("20", "27", "62", "36", "32", "44", "40", "68", "45", "42")
        val arrDesc = arrayOf("Évariste Galois was a French Scientist, who passed away on the 31 of May 1832 at the age of 20. He was famous for improving the study of group theory in maths.", "Jimi Hendrix was an American Rock artist, who passed away on the 18 of September 1970 at the age of 27. He pioneered the modern sound of rock using electric guitars and the use of what is called stereophonic phasing effects.", "J.Robert Oppenheimer was an American Physicist, who passed away on the 18th of Feb 1967 at the age of 62. He was the inventor of the atomic bomb and the director of the Los Alamos Laboratory.", "Diana, Princess of Wales passed away on the 31st of August 1997 at the age of 36. In spite of her royal status she was a kind natured person and donated a lot to charity.", "Bruce Lee was an actor and martial artist, who passed away on the 20th of July 1973 at the age of 32. He was well know as an actor and notable for starring in Enter the Dragon.", "Steve Irwin was an Australian zookeeper and conservationist, who passed away on the 4th of september 2006 at the age of 44. He was well know for wrestling crocodiles and advocating for nature conservation.", "John Lennon was an English singer, songwriter and co-vocalist, co-songwriter and rhythm guitarist, who passed away on the 8th of December 1980 at the age of 40. He was well known as a member of the Beetles, an incredibly popular english band.", "Akira Toriyama was a Japanese Manga artist, who passed away on the 1st of March 2024 at the age of 68. He is well known as the creator of the Manga series Dragon ball, co-creator of the video game dragon quest and the co-creator of Chrono Trigger.", "Freddie Mercury was a British singer/songwriter, who passed away on the 24th of November 1991 at the age of 45. He was know for being the lead vocalist and songwriter of the popular american band Queen.", "Elvis Presley was an American singer and actor, who passed away on the 16th of August 1977 at the age of 42. He was an incredibly popular musician and was dubbed the king of rock and roll.")
        var intIndex :Int = 0
        //intSearchLimit is set to 1 rather than 0 to prevent a fatal crash occurring where int index reaches value 20, a value higher than the spaces within arrNum
        var intSearchLimit :Int = 1

        //Setting imgWarning, strWarning1 and strWarning2 to invisible
        imgWarning.setVisibility(View.INVISIBLE)
        strWarning1.setVisibility(View.INVISIBLE)
        strWarning2.setVisibility(View.INVISIBLE)

        //Removing placeholder text on etNum
        etNum.setOnClickListener{
            etNum.setText("")
        }
        
        btnGenerate.setOnClickListener {

            if (etNum.text.toString().toInt() > 19 && etNum.text.toString().toInt() < 101) {
                //Setting imgWarning, strWarning1 and strWarning2 to invisible
                imgWarning.setVisibility(View.INVISIBLE)
                strWarning1.setVisibility(View.INVISIBLE)
                strWarning2.setVisibility(View.INVISIBLE)

                //A while loop that scans through the entirety of arrAge to check if one of the values in the array match the age the user specified
                while (etNum.text.toString() != arrAge[intIndex] && intSearchLimit != 10) {
                    intIndex++
                    intSearchLimit++
                }

                //Changing text on tvDisplay to the information relating to the person who died at the age the user specified
                if (intSearchLimit != 10) {
                    tvDisplay.setText(arrDesc[intIndex])
                } else {

                    //Displaying to the user that the number they specified while in range, still doesnt match any of the ages in arrAge
                    //Setting imgWarning, strWarning1 and strWarning2 to visible
                    imgWarning.setVisibility(View.VISIBLE)
                    strWarning2.setVisibility(View.VISIBLE)
                    strWarning1.setVisibility(View.INVISIBLE)

                }
                //Resetting the value of intIndex and intSearchLimit so that the search process above can be repeated by the user
                intIndex = 0
                intSearchLimit = 1

            } else {

                //Setting imgWarning and strWarning1 to visible
                imgWarning.setVisibility(View.VISIBLE)
                strWarning1.setVisibility(View.VISIBLE)
                strWarning2.setVisibility(View.INVISIBLE)

            }
        }

        //Clear
        btnClear.setOnClickListener{

            imgWarning.setVisibility(View.INVISIBLE)
            strWarning1.setVisibility(View.INVISIBLE)
            strWarning2.setVisibility(View.INVISIBLE)

            tvDisplay.setText(null)
            etNum.setText("1")
        }
    }
}