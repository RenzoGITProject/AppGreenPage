package com.alonsoms.appt1alonsoms

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alonsoms.appt1alonsoms.databinding.ActivityInicioBinding
import com.alonsoms.appt1alonsoms.util.DrawerBaseActivity

class linearLayout_04 : DrawerBaseActivity() {

    private lateinit var activityInicioBinding: ActivityInicioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        activityInicioBinding = ActivityInicioBinding.inflate(layoutInflater)
        setContentView(activityInicioBinding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
