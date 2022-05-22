package io.github.hydrazinemc.server.util

enum class RotationAmount(val asRadians: Double = 0.0, val asDegrees: Float = 0f) {
	CLOCKWISE(-Math.PI / 2, -90f),
	COUNTERCLOCKWISE(Math.PI / 2, 90f),
	REVERSE(Math.PI, 180f),
	NONE,
}