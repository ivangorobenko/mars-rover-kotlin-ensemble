data class Position(val x: Int, val y: Int) {

    fun nextPositionIn(direction: Direction): Position {
        return when (direction) {
            Direction.NORTH -> Position(x, y - 1)
            Direction.SOUTH -> Position(x, y + 1)
            Direction.EAST -> Position(x + 1, y)
            Direction.WEST -> Position(x - 1, y)
        }
    }

}