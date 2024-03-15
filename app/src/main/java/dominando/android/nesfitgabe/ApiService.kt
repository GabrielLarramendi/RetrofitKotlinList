package dominando.android.nesfitgabe

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("people")
    fun getPeople() : Call<PeopleResponse>
}