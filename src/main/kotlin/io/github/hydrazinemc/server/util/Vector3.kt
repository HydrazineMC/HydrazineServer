package io.github.hydrazinemc.server.util

import kotlin.math.cos
import kotlin.math.sin

/**
 * A container for three Doubles, [x], [y], and [z]
 */
data class Vector3(var x: Double, var y: Double, var z: Double) {

	companion object {
		val zero = Vector3(0.0, 0.0, 0.0)
	}

	operator fun plus(other: Vector3) = Vector3(x + other.x, y + other.y, z + other.z)
	operator fun minus(other: Vector3) = Vector3(x - other.x, y - other.y, z - other.z)
	operator fun times(other: Float) = Vector3(x * other, y * other, z * other)

	/**
	 * Get this position rotated around [origin] by [theta] radians
	 * @see rotateCoordinates
	 */
	fun rotateAround(origin: Vector3, theta: Double) = rotateCoordinates(this, origin, theta)

	/**
	 * Get this position rotated around [origin] by [rotation]
	 * @see rotateCoordinates
	 */
	fun rotateAround(origin: Vector3, rotation: RotationAmount) = rotateCoordinates(this, origin, rotation)
}


/**
 * Rotate [loc] around [origin] by [theta] radians.
 * Note, [theta] positive = clockwise, negative = counter clockwise
 * @see Vector3.rotateAround
 */
fun rotateCoordinates(loc: Vector3, origin: Vector3, theta: Double): Vector3 = Vector3(
	origin.x + (((loc.x - origin.x) * cos(theta)) - ((loc.z - origin.z) * sin(theta))),
	loc.y,  // too many parentheses is better than too few
	origin.z + (((loc.x - origin.x) * sin(theta)) + ((loc.z - origin.z) * cos(theta))),
)

/**
 * Rotate [loc] [rotation] around [origin]
 * @see Vector3.rotateAround
 */
fun rotateCoordinates(loc: Vector3, origin: Vector3, rotation: RotationAmount): Vector3 =
	rotateCoordinates(loc, origin, rotation.asRadians)