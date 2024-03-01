import kotlin.math.E

enum class Direction {
    NORTH, SOUTH, EAST, WEST;

    fun opposite(): Direction {
        return when (this) {
            NORTH -> SOUTH
            SOUTH -> NORTH
            EAST -> WEST
            WEST -> EAST
        }
    }
}
