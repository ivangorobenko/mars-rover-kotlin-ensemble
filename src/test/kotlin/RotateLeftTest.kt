import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


class RotateLeftTest {
    @ParameterizedTest
    @MethodSource("rotateLeftParameters")
    fun `moves the rover forward for all directions`(
        direction: Direction,
        expectedDirection: Direction
    ) {
        val rover = Rover(direction, somePosition())
        val roverThatMoved = rover.rotateLeft()
        Assertions.assertThat(roverThatMoved).isEqualTo(Rover(expectedDirection, somePosition()))
    }

    private fun somePosition(): Position {
        return Position(0, 0)
    }

    companion object {
        @JvmStatic
        fun rotateLeftParameters(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(Direction.NORTH, Direction.WEST),
            )
        }
    }
}

