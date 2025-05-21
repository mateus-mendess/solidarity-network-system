package com.mg.solidaritynetwork.dto.response;

public record GlobalErrorResponse(Integer status, String field, String message) {
}
