import io.mockk.every
import io.mockk.verify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.impl.annotations.SpyK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class MockkTest {
    @MockK
    private lateinit var car1: Car

    @RelaxedMockK
    private lateinit var car2: Car

    @MockK(relaxUnitFun = true)
    private lateinit var car3: Car

    @SpyK
    private var car4 = Car()

    @InjectMockKs
    private var sut = TrafficSystem()

    @Test
    fun test() {
        // given
        every { car1.drive(Direction.NORTH) } returns OutCome.OK
        every { car3.drive(any()) } returns OutCome.OK
        // when
        sut.doAction()
        // then
        verify(exactly = 1) { car1.drive(any()) }
    }
}
