package info.ort.recyclerkotlin.Activity

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.littlemango.stacklayoutmanager.StackLayoutManager
import info.ort.recyclerkotlin.ColorPicker
import info.ort.recyclerkotlin.Model.Article
import info.ort.recyclerkotlin.Model.NewsClass
import info.ort.recyclerkotlin.NewsInterface
import info.ort.recyclerkotlin.R
import info.ort.recyclerkotlin.adapters.NewsAdapter
import kotlinx.android.synthetic.main.activity_main2.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {


    lateinit var adapter1: NewsAdapter;
    private var article= mutableListOf<Article>()
    var pagenum=1
    var totalResult=-1
    val TAG="MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //var newslist=findViewById(R.id.newslist)
       // val songs= listOf<String>("Hello","ABCD","Dance","Chill","Coders Life","Quarantine","Hello","ABCD","Dance","Chill","Coders Life","Quarantine","Hello","ABCD","Dance","Chill","Coders Life","Quarantine")
      /* val songobjects= mutableListOf<Songs>()
        songobjects.add(Songs("Hello","Just the description"))
        songobjects.add(Songs("ABCD","John Lebanonn"))
        songobjects.add(Songs("Dance","The Rolling Stones"))
        songobjects.add(Songs("Chill","The Beatles"))
        songobjects.add(Songs("Coders Life","Just the Description"))
        songobjects.add(Songs("Aadayein bhi Mohabhat bhi Hai","OK Jaanu"))
        songobjects.add(Songs("Aye Udi Udi","Saathiyaaa"))
        songobjects.add(Songs("Itna Sona Sona","Random Select"))
        songobjects.add(Songs("IT IT IT","Wells"))
        songobjects.add(Songs("Agar Tum Mil Jao","Radom Select"))
        songobjects.add(Songs("Ban Ja Tu Rani","Sulu"))*/



        //recycle_songlist.adapter=adapter
        //adapter.addItems(songobjects)
        //recycle_songlist.layoutManager=LinearLayoutManager(this)

        adapter1= NewsAdapter(
            this@MainActivity,
            article,
            { selectedFruitItem: Article -> clicked(selectedFruitItem) })
        newslist.adapter=adapter1
        //newslist.layoutManager=LinearLayoutManager(this@MainActivity)


        val layoutManager=StackLayoutManager(StackLayoutManager.ScrollOrientation.BOTTOM_TO_TOP)
        layoutManager.setPagerMode(true)
        layoutManager.setPagerFlingVelocity(3000)
        layoutManager.setItemChangedListener(object:StackLayoutManager.ItemChangedListener{
            override fun onItemChanged(position: Int) {
                container.setBackgroundColor(Color.parseColor(ColorPicker.getColor()))
                Log.d(TAG,"First Visible Item - ${layoutManager.getFirstVisibleItemPosition()}")
                Log.d(TAG,"Total Count - ${layoutManager.itemCount}")
                if(totalResult > layoutManager.itemCount && layoutManager.getFirstVisibleItemPosition() >= layoutManager.itemCount-5){
                    pagenum++
                    getNews()
                }
            }

        })
        newslist.layoutManager=layoutManager
        getNews()
    }

    private fun clicked(article: Article){
        val uri = Uri.parse(article.url)
        val intent=Intent(applicationContext,
            MainActivity2::class.java)
        intent.putExtra("URL",article.url)
        startActivity(intent)

    }

    private fun getNews() {
        Log.d(TAG,"Requst sent for ${pagenum}")
        val news= NewsInterface.NewsService.newsinstance.getHeadlines("in",pagenum)
        news.enqueue(object :Callback<NewsClass>{
            override fun onFailure(call: Call<NewsClass>, t: Throwable) {
                Log.d("CHHEEZYCODE","Error in Fetching",t);
            }

            override fun onResponse(call: Call<NewsClass>, response: Response<NewsClass>) {
                val news=response.body()
                if(news!=null){
                    totalResult=news.totalResults
                    Log.d("NEWS",news.toString())
                   article.addAll(news.articles)
                    adapter1.notifyDataSetChanged()
                }
            }
        })
    }
}