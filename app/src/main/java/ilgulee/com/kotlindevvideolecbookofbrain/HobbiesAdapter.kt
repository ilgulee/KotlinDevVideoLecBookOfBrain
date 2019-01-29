package ilgulee.com.kotlindevvideolecbookofbrain

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class HobbiesAdapter(private val context: Context, private val hobbiesList: List<Hobby>) :
    RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var pos: Int = 0
        private var currentHobby: Hobby? = null

        init {
            itemView.setOnClickListener {
                Toast.makeText(context, currentHobby!!.title + " clicked", Toast.LENGTH_LONG).show()
            }
            itemView.imageView_share.setOnClickListener {
                val message: String = "My hobby is : " + currentHobby!!.title
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, message)
                intent.type = "plain/text"
                context.startActivity(Intent.createChooser(intent, "Share to: "))
            }
        }

        fun setData(hobby: Hobby?, position: Int) {
            itemView.textView_title.text = hobby!!.title
            this.pos = position
            this.currentHobby = hobby
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HobbiesAdapter.MyViewHolder {
        // create a new view
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return MyViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        val hobby = hobbiesList.get(position);
        holder.setData(hobby, position)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int = hobbiesList.size
}