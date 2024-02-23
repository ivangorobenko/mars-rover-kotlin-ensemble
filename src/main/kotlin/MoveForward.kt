class MoveForward {
    fun compute(position: Position, direction: Direction): Position {
        return when (direction) {
            Direction.NORTH -> position.moveNorth()
            Direction.SOUTH -> position.moveSouth()
            Direction.EAST -> position.moveEast()
            Direction.WEST -> position.moveWest()
        }
    }
}