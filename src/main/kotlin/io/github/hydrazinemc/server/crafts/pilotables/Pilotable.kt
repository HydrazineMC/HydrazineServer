package io.github.hydrazinemc.server.crafts.pilotables

import io.github.hydrazinemc.server.crafts.Craft
import net.minestom.server.entity.Player

open class Pilotable: Craft() {
	var pilot: Player? = null
		private set
	var owner: Player? = null
		private set

	fun pilotCraft(player: Player) {

	}
	fun unpilotCraft(player: Player) {

	}
}