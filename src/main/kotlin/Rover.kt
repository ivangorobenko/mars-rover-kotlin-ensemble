data class Rover(val direction: Direction, val position: Position) {

    fun moveForward(): Rover {
        return Rover(
            direction,
            position.nextPositionIn(direction)
        )
    }

    fun moveBackward(): Rover {
        return Rover(
            direction,
            position.nextPositionIn(direction.opposite())
        )
    }

    fun rotateLeft(): Rover {
        TODO("Not yet implemented")
    }

}
