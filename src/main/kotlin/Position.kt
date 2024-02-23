data class Position(val x: Int, val y: Int) {
    fun moveSouth(): Position {
        return Position(x, y + 1)
    }

    fun moveNorth(): Position {
        return Position(x, y - 1)
    }

    fun moveEast(): Position {
        return Position(x + 1, y)
    }

    fun moveWest(): Position {
        return Position(x - 1, y)
    }
}