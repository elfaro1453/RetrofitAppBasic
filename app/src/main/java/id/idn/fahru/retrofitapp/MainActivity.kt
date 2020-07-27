package id.idn.fahru.retrofitapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import id.idn.fahru.retrofitapp.retrofit.RetrofitInterfaces
import id.idn.fahru.retrofitapp.retrofit.RetrofitService
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // retrofitService
        val retrofitService = RetrofitService.buildService(RetrofitInterfaces::class.java)

        lifecycleScope.launch {
            val request = retrofitService.topHeadlines()
            if (request.isSuccessful) {

                // Bikin Toast kalau berhasil
                Toast.makeText(
                    this@MainActivity,
                    request.body()?.totalResults.toString(),
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Log.e("MainActivity", request.errorBody().toString())
            }
        }
    }
}
