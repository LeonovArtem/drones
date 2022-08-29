package com.aleonov.drones.data.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DroneBatteryLevelResponseDto {
	private Long droneId;
	private int batteryLevel;
	private String message;
}
