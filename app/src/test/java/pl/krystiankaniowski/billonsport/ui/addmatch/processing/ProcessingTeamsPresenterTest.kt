package pl.krystiankaniowski.billonsport.ui.addmatch.processing

import org.junit.Assert
import org.junit.Test
import pl.krystiankaniowski.billonsport.core.data.Player
import pl.krystiankaniowski.billonsport.core.data.Rating

class ProcessingTeamsPresenterTest {

	val instance = ProcessingTeamsPresenter()

	@Test
	fun `createVirtualPlayerForOddList`() {
		Assert.assertTrue(instance.createVirtualPlayer(generateList(3)) != null)
	}

	@Test
	fun `notCreateVirtualPlayerForEvenList`() {
		Assert.assertTrue(instance.createVirtualPlayer(generateList(4)) == null)
	}

	@Test
	fun `validateCreatedPlayerIsVirtual`() {
		Assert.assertTrue(instance.createVirtualPlayer(generateList(3))!!.virtual)
	}

	@Test
	fun `validateCreatedVirtualPlayer`() {
		val (mean, unconfident) = instance.createVirtualPlayer(generateList(3))!!.rating
		Assert.assertEquals(mean, 25f)
		Assert.assertEquals(unconfident, 8.3f)
	}

	private fun generateList(count: Int): List<Player> {
		return List(count, { Player(it.toString(), "p$it", "p$it", "p$it", Rating(25f, 8.3f)) })
	}

}