package chaymaeidrissi.ma.neighbors.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import chaymaeidrissi.ma.neighbors.R
import chaymaeidrissi.ma.neighbors.adapters.ListNeighborHandler
import chaymaeidrissi.ma.neighbors.adapters.ListNeighborsAdapter
import chaymaeidrissi.ma.neighbors.data.NeighborRepository
import chaymaeidrissi.ma.neighbors.models.Neighbor

class ListNeighborsFragment: Fragment(), ListNeighborHandler {
    /**
     * Fonction permettant de définir une vue à attacher à un fragment
     */
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.list_neighbors_fragment, container, false)
        recyclerView = view.findViewById(R.id.neighbors_list)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        return view
        //return inflater.inflate(R.layout.list_neighbors_fragment, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val neighbors = NeighborRepository.getInstance().getNeighbours()
        val adapter = ListNeighborsAdapter(neighbors, this)
        recyclerView.adapter = adapter

    }

    override val addNeighbor: Any
        get() = TODO("Not yet implemented")


    override fun onDeleteNeibor(neighbor: Neighbor) {
        //if (context != null) { //... }   -----  context?.let
        context?.let {
            val builder = AlertDialog.Builder(it)
            builder
                .setTitle(R.string.alert_title)
                .setMessage(R.string.alert_message)
                .setPositiveButton(R.string.btn_oui)
                { dialog, id ->
                    NeighborRepository.getInstance().remove(neighbor)
                    recyclerView.adapter?.notifyDataSetChanged()
                }
                .setNegativeButton(
                    R.string.btn_non
                ) { dialog, id ->
                    //user cancelled the dialog
                }
            //create the AlertDialog.object and return it
            builder.create()
                .show()
        }

    }
}