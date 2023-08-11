package br.study.mixing.base64.converts;

import br.study.mixing.base64.Base64Exception;

public interface ConvertStringAndNumber {
    int convert(String input) throws Base64Exception;
    String unconvert(int number) throws Base64Exception;
}
