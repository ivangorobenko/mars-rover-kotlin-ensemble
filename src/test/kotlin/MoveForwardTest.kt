import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class MoveForwardTest {

    @Test
    fun `moves the rover forward when facing north`() {
        val rover = Rover(Direction.NORTH, Position(1, 7))
        val roverThatMoved = rover.execute(MoveForward())
        Assertions.assertThat(roverThatMoved).isEqualTo(Rover(Direction.NORTH, Position(1, 6)))
    }

    @Test
    fun `moves the rover forward when facing south`() {
        val rover = Rover(Direction.SOUTH, Position(1, 7))
        val roverThatMoved = rover.execute(MoveForward())
        Assertions.assertThat(roverThatMoved).isEqualTo(Rover(Direction.SOUTH, Position(1, 8)))
    }

    @Test
    fun `moves the rover forward when facing east`() {
        val rover = Rover(Direction.EAST, Position(1, 7))
        val roverThatMoved = rover.execute(MoveForward())
        Assertions.assertThat(roverThatMoved).isEqualTo(Rover(Direction.EAST, Position(2, 7)))
    }

    @Test
    fun `moves the rover forward when facing west`() {
        val rover = Rover(Direction.WEST, Position(1, 7))
        val roverThatMoved = rover.execute(MoveForward())
        Assertions.assertThat(roverThatMoved).isEqualTo(Rover(Direction.WEST, Position(0, 7)))
    }
}

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

enum class Direction {
    NORTH, SOUTH, EAST, WEST
}

data class Rover(val direction: Direction, val position: Position) {
    fun execute(moveForward: MoveForward): Rover {
        return Rover(this.direction, moveForward.compute(position, direction))
    }

}
