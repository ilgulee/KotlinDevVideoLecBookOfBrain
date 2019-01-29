package ilgulee.com.kotlindevvideolecbookofbrain.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ilgulee.com.kotlindevvideolecbookofbrain.R
import ilgulee.com.kotlindevvideolecbookofbrain.adapters.HobbiesAdapter
import ilgulee.com.kotlindevvideolecbookofbrain.models.Hobby

class HobbyListActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hobbies)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        viewManager = LinearLayoutManager(this)
        viewAdapter = HobbiesAdapter(
            this,
            Hobby.Supplier.hobbies
        )
        recyclerView = findViewById<RecyclerView>(R.id.recycler_view).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }
    }
}