data class Rover(val direction: Direction, val position: Position) {

    fun moveForward(): Rover {
        return Rover(
            direction,
            position.nextPositionIn(direction)
        )
    }

}
