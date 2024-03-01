data class Rover(val direction: Direction, val position: Position) {

    fun moveForward(): Rover {
        return Rover(
            direction,
            when (direction) {
                Direction.NORTH -> position.moveNorth()
                Direction.SOUTH -> position.moveSouth()
                Direction.EAST -> position.moveEast()
                Direction.WEST -> position.moveWest()
            }
        )
    }

}
