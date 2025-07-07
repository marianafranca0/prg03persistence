/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.util;

/**
 *
 * @author waria
 */

// Classe que contém método de VALIDAÇÃO usado pelo Service
//-----------------------------------------------------------
public class StringUtil {
      public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
