package io.github.hydrazinemc.server.crafts

import io.github.hydrazinemc.server.util.RotationAmount
import io.github.hydrazinemc.server.util.Vector3
import net.minestom.server.entity.LivingEntity
import net.minestom.server.instance.block.Block


abstract class Craft {
	var passengers = mutableSetOf<LivingEntity>()
	var detectableBlocks = mutableSetOf<Block>()

	fun detect() {}
	fun move(offset: Vector3) {
		movePassengers(offset, RotationAmount.NONE)
	}
	fun rotate(rotation: RotationAmount) {
		movePassengers(Vector3.zero, rotation)
	}
	fun movePassengers(offset: Vector3, rotation: RotationAmount) {

	}
	fun changeWorld() {}
}