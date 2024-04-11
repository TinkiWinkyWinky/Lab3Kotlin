package com.example.tp3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_option1 -> {
                val listView = ListView(this)
                val dataList = listOf("Élément 1", "Élément 2", "Élément 3")
                val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dataList)
                listView.adapter = adapter
                val linearLayout = findViewById<LinearLayout>(R.id.linearLayout)
                linearLayout.addView(listView)

                listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
                    val selectedItem = adapter.getItem(position)
                    Toast.makeText(this, "Élément sélectionné : $selectedItem", Toast.LENGTH_SHORT).show()
                }

                true
            }
            R.id.action_option2 -> {
                val imageView = ImageView(this)
                imageView.setImageResource(R.mipmap.ic_launcher)

                val linearLayout = findViewById<LinearLayout>(R.id.linearLayout)

                val layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                var currentGravity = Gravity.CENTER

                layoutParams.gravity = currentGravity
                linearLayout.addView(imageView, layoutParams)

                /*imageView.setOnHoverListener { view, motionEvent ->
                    when (motionEvent.action) {
                        MotionEvent.ACTION_HOVER_ENTER -> {
                            currentGravity = when (currentGravity) {
                                Gravity.CENTER -> {
                                    if (Random.nextInt(2) == 0) {
                                        layoutParams.gravity = Gravity.START
                                        Gravity.START
                                    } else {
                                        layoutParams.gravity = Gravity.END
                                        Gravity.END
                                    }
                                }
                                Gravity.START -> {
                                    if (Random.nextInt(2) == 0) {
                                        layoutParams.gravity = Gravity.CENTER
                                        Gravity.CENTER
                                    } else {
                                        layoutParams.gravity = Gravity.END
                                        Gravity.END
                                    }
                                }
                                else -> {
                                    if (Random.nextInt(2) == 0) {
                                        layoutParams.gravity = Gravity.CENTER
                                        Gravity.CENTER
                                    } else {
                                        layoutParams.gravity = Gravity.START
                                        Gravity.START
                                    }
                                }
                            }

                            imageView.layoutParams = layoutParams
                            true // Retourne true pour indiquer que l'événement a été traité
                        }
                        MotionEvent.ACTION_HOVER_EXIT -> {
                            // Code à exécuter lorsque le hover se termine
                            true // Retourne true pour indiquer que l'événement a été traité
                        }
                        else -> false // Retourne false pour indiquer que l'événement n'est pas traité
                    }
                }*/

                imageView.setOnClickListener {
                    currentGravity = when (currentGravity) {
                        Gravity.CENTER -> {
                            if (Random.nextInt(2) == 0) {
                                layoutParams.gravity = Gravity.START
                                Gravity.START
                            } else {
                                layoutParams.gravity = Gravity.END
                                Gravity.END
                            }
                        }
                        Gravity.START -> {
                            if (Random.nextInt(2) == 0) {
                                layoutParams.gravity = Gravity.CENTER
                                Gravity.CENTER
                            } else {
                                layoutParams.gravity = Gravity.END
                                Gravity.END
                            }
                        }
                        else -> {
                            if (Random.nextInt(2) == 0) {
                                layoutParams.gravity = Gravity.CENTER
                                Gravity.CENTER
                            } else {
                                layoutParams.gravity = Gravity.START
                                Gravity.START
                            }
                        }
                    }

                    imageView.layoutParams = layoutParams
                }

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}