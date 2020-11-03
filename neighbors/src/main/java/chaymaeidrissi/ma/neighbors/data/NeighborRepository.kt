package chaymaeidrissi.ma.neighbors.data

import chaymaeidrissi.ma.neighbors.data.service.DummyNeighborApiService
import chaymaeidrissi.ma.neighbors.data.service.NeighborApiService
import chaymaeidrissi.ma.neighbors.models.Neighbor

class NeighborRepository {
    private val apiService: NeighborApiService

    init {
        apiService = DummyNeighborApiService()
    }

    fun getNeighbours(): List<Neighbor> = apiService.neighbours
    fun remove(neighbor: Neighbor) = apiService.deleteNeighbour(neighbor)
    fun createNeighbour(neighbor: Neighbor) = apiService.createNeighbour(neighbor)


    companion object {
        private var instance: NeighborRepository? = null
        fun getInstance(): NeighborRepository {
            if (instance == null) {
                instance = NeighborRepository()
            }
            return instance!!
        }
    }
}