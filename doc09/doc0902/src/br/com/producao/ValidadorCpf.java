package br.com.producao;

public class ValidadorCpf {
    public static boolean validarCpf(String cpf) {
        if (cpf == null || cpf.isEmpty()) {
            throw new IllegalArgumentException("O CPF não pode ser nulo ou vazio.");
        }

        // Verificar se contém apenas números
        if (!cpf.matches("\\d+")) {
            throw new IllegalArgumentException("O CPF deve conter apenas números.");
        }

        // Verificar a quantidade de dígitos
        if (cpf.length() != 11) {
            throw new IllegalArgumentException("O CPF deve conter exatamente 11 dígitos numéricos.");
        }

        // Converter string em array int
        int[] cpfInt = new int[cpf.length()];
        for (int i = 0; i < cpf.length(); i++) {
            cpfInt[i] = Character.getNumericValue(cpf.charAt(i));
        }

        // Verificar se todos os dígitos são iguais
        boolean todosDigitosIguais = true;
        for (int i = 1; i < cpfInt.length; i++) {
            if (cpfInt[i] != cpfInt[0]) {
                todosDigitosIguais = false;
                break;
            }
        }
        if (todosDigitosIguais) {
            throw new IllegalArgumentException("O CPF não pode conter todos os dígitos iguais.");
        }

        // Fase de multiplicação PDV
        int pdv = 0;
        int[] pdvVet = new int[cpf.length() - 2];
        int q = 10;
        for (int i = 0; i < pdvVet.length; i++) {
            pdvVet[i] = cpfInt[i] * q;
            q--;
        }

        // Fase de soma PDV
        for (int i = 0; i < pdvVet.length; i++) {
            pdv += pdvVet[i];
        }

        // Gerar PDV
        if (pdv % 11 < 2) {
            pdv = 0;
        } else {
            pdv = 11 - (pdv % 11);
        }

        // Fase de multiplicação SDV
        int sdv = 0;
        int[] sdvVet = new int[cpf.length() - 2];
        q = 11;
        for (int i = 0; i < sdvVet.length; i++) {
            sdvVet[i] = cpfInt[i] * q;
            q--;
        }

        // Fase de soma SDV
        for (int i = 0; i < sdvVet.length; i++) {
            sdv += sdvVet[i];
        }

        // Gerar SDV
        sdv = sdv + pdv * 2;
        if (sdv % 11 < 2) {
            sdv = 0;
        } else {
            sdv = 11 - (sdv % 11);
        }

        // Comparar dígitos verificadores
        if (pdv != cpfInt[cpf.length() - 2] || sdv != cpfInt[cpf.length() - 1]) {
            throw new IllegalArgumentException("O CPF fornecido é inválido.");
        }

        return true;
    }
}
