package chaymaeidrissi.ma.neighbors.adapters

import chaymaeidrissi.ma.neighbors.models.Neighbor

interface ListNeighborHandler {
    abstract val addNeighbor: Any

    fun onDeleteNeibor(neighbor: Neighbor)
}