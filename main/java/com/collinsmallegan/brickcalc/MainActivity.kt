package com.collinsmallegan.brickcalc


import android.os.Bundle

import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.collinsmallegan.brickcalc.R.id.tabs_main
import com.collinsmallegan.brickcalc.R.id.viewpager_main
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    fun toast(string: String) {
        Toast.makeText(this, "Enter a $string", Toast.LENGTH_SHORT).show()
    }


    fun calculateLandscape(view: View) {

        var calculateState = true

        val width =  findViewById<EditText>(R.id.landWidth)
        val length = findViewById<EditText>(R.id.landLength)

        val brickDepth = findViewById<EditText>(R.id.landDepthBrick)
        val brickWidth = findViewById<EditText>(R.id.landWidthBrick)
        val row = findViewById<EditText>(R.id.landRow)

        val area = findViewById<TextView>(R.id.landArea)
        val brickCount = findViewById<TextView>(R.id.landBrickCount)

        val sWidth = width.text.toString()
        val sLength = length.text.toString()
        val sBrickDepth = brickDepth.text.toString()
        val sBrickWidth = brickWidth.text.toString()
        val sRow = row.text.toString()

        if (sWidth.matches("".toRegex())) {
            calculateState = false
            toast("Width")
        } else if (sLength.matches("".toRegex())) {
            calculateState = false
            toast("Length")
        } else if (sBrickDepth.matches("".toRegex())) {
            calculateState = false
            toast("Brick Depth")
        } else if (sBrickWidth.matches("".toRegex())) {
            calculateState = false
            toast("Brick Width")

        } else if (sRow.matches("".toRegex())) {
            calculateState = false
            toast("Row")

        }
        if (calculateState) {
            val widthInt = java.lang.Double.valueOf(width.text.toString())!! * 12.0
            val lengthInt = java.lang.Double.valueOf(length.text.toString())!! * 12.0

            val brickDepthInt = java.lang.Double.valueOf(brickDepth.text.toString())!!
            val brickWidthInt = java.lang.Double.valueOf(brickWidth.text.toString())!!
            val rowInt = java.lang.Double.valueOf(row.text.toString())!!

            val perimeterInt = (widthInt + (lengthInt - brickDepthInt * 2.0)) * 2.0


            if (brickDepthInt < lengthInt && brickWidthInt < widthInt) {

                val finalBrickCount = Math.round(perimeterInt / brickWidthInt * rowInt * 10.0) / 10.0
                val areaFinal = Math.round(widthInt / 12.0 * (lengthInt / 12.0) * 100.0) / 100.0

                brickCount.text = java.lang.Double.toString(finalBrickCount) + " Bricks"
                area.text = java.lang.Double.toString(areaFinal) + " Squared FT "

            } else {


                toast("The brick can't be bigger than the yard!")

            }

        }
    }

    fun calculatePavers(view: View){
        var calculateState = true

        val width =  findViewById<EditText>(R.id.paverWidth)
        val length = findViewById<EditText>(R.id.paverLength)

        val brickDepth = findViewById<EditText>(R.id.paverDepthBrick)
        val brickWidth = findViewById<EditText>(R.id.paverWidthBrick)


        val area = findViewById<TextView>(R.id.paverArea)
        val brickCount = findViewById<TextView>(R.id.paverBrickCount)

        val sWidth = width.text.toString()
        val sLength = length.text.toString()
        val sBrickDepth = brickDepth.text.toString()
        val sBrickWidth = brickWidth.text.toString()


        if (sWidth.matches("".toRegex())) {
            calculateState = false
            toast("Width")
        } else if (sLength.matches("".toRegex())) {
            calculateState = false
            toast("Length")
        } else if (sBrickDepth.matches("".toRegex())) {
            calculateState = false
            toast("Brick Depth")
        } else if (sBrickWidth.matches("".toRegex())) {
            calculateState = false
            toast("Brick Width")

        }
        if (calculateState) {
            val widthInt = java.lang.Double.valueOf(width.text.toString())!! * 12.0
            val lengthInt = java.lang.Double.valueOf(length.text.toString())!! * 12.0

            val brickDepthInt = java.lang.Double.valueOf(brickDepth.text.toString())!!
            val brickWidthInt = java.lang.Double.valueOf(brickWidth.text.toString())!!




            if (brickDepthInt < lengthInt && brickWidthInt < widthInt) {
                val areaFinal = Math.round(widthInt / 12.0 * (lengthInt / 12.0) * 100.0) / 100.0
                val brickArea = (brickDepthInt/12) * (brickWidthInt/12)
                val finalBrickCount = Math.round(areaFinal/brickArea* 10.0) / 10.0


                brickCount.text = java.lang.Double.toString(finalBrickCount) + " Bricks"
                area.text = java.lang.Double.toString(areaFinal) + " Squared FT "

            } else {


                toast("The brick can't be bigger than the yard!")

            }

        }

    }

    fun calculateWall(view: View) {

        var calculateState = true

        val width =  findViewById<EditText>(R.id.wallWidth)
        val length = findViewById<EditText>(R.id.wallLength)
        val height = findViewById<EditText>(R.id.wallHeight)

        val brickDepth = findViewById<EditText>(R.id.wallDepthBrick)
        val brickWidth = findViewById<EditText>(R.id.wallWidthBrick)
        val brickHeight = findViewById<EditText>(R.id.wallHeightBrick)

        val area = findViewById<TextView>(R.id.landArea)
        val brickCount = findViewById<TextView>(R.id.landBrickCount)

        val sWidth = width.text.toString()
        val sLength = length.text.toString()
        val sBrickDepth = brickDepth.text.toString()
        val sBrickWidth = brickWidth.text.toString()
        val sBrickHeight = brickHeight.text.toString()


        if (sWidth.matches("".toRegex())) {
            calculateState = false
            toast("Width")
        } else if (sLength.matches("".toRegex())) {
            calculateState = false
            toast("Length")
        } else if (sBrickDepth.matches("".toRegex())) {
            calculateState = false
            toast("Brick Depth")
        } else if (sBrickWidth.matches("".toRegex())) {
            calculateState = false
            toast("Brick Width")

        } else if (sBrickHeight.matches("".toRegex())) {
            calculateState = false
            toast("Row")

        }
        if (calculateState) {
            val widthInt = java.lang.Double.valueOf(width.text.toString())!! * 12.0
            val lengthInt = java.lang.Double.valueOf(length.text.toString())!! * 12.0
            val heightInt = java.lang.Double.valueOf(height.text.toString())!! * 12.0

            val brickDepthInt = java.lang.Double.valueOf(brickDepth.text.toString())!!
            val brickWidthInt = java.lang.Double.valueOf(brickWidth.text.toString())!!
            val brickHeightInt = java.lang.Double.valueOf(brickHeight.text.toString())!!

            val perimeterInt = (widthInt + (lengthInt - brickDepthInt * 2.0)) * 2.0
            val rowInt = (heightInt/brickHeightInt)

            if (brickDepthInt < lengthInt && brickWidthInt < widthInt) {

                val finalBrickCount = Math.round(perimeterInt / brickWidthInt * rowInt * 10.0) / 10.0
                val areaFinal = Math.round(widthInt / 12.0 * (lengthInt / 12.0) * 100.0) / 100.0

                brickCount.text = java.lang.Double.toString(finalBrickCount) + " Bricks"
                area.text = java.lang.Double.toString(areaFinal) + " Squared FT "
                Log.i("row", rowInt.toString())

            } else {


                toast("The brick can't be bigger than the structure!")

            }

        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentAdapter = com.collinsmallegan.brickcalc.PagerAdapter(supportFragmentManager)
        viewpager_main.adapter = fragmentAdapter

        tabs_main.setupWithViewPager(viewpager_main)
    }
}