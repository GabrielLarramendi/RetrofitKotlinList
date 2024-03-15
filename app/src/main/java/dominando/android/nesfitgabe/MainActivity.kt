package dominando.android.nesfitgabe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var people = arrayListOf<PersonDetails>()

    private var adapter = PersonDetailsAdapter(people)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val request = ApiClient.apiService.getPeople()

        initRecyclerView()
        request.enqueue(object: retrofit2.Callback<PeopleResponse> {
            override fun onResponse(
                call: Call<PeopleResponse>,
                response: Response<PeopleResponse>
            ) {

                if (response.body()?.results != null) {
                    people.addAll(response.body()?.results!!)
                    adapter.notifyItemRangeChanged(0, response.body()?.results!!.size)
                } else {
                    println("No response")
                }
            }

            override fun onFailure(call: Call<PeopleResponse>, t: Throwable) {
                println("Falha")
            }
        })
    }

    private fun initRecyclerView() {
        val rvPersonDetails = findViewById<RecyclerView>(R.id.rv_characters)
        rvPersonDetails.adapter = adapter
        val layoutManager = GridLayoutManager(this, 1)
        rvPersonDetails.layoutManager = layoutManager
    }

}