int uint32_t {*origindata ;
int uint32_t (row_num, uint32_t row_size) ;{
    gf_error_t err = GF_SUCCESS;
    uint32_t row = 0;
    uint32_t i = 0;
    uint32_t index = 0;
    uint8_t *buffer = NULL;
    FUNC_ENTER();

    do {
        if (NULL == origindata) {
            err = -1;
            break;
        }
        
        for (row = 0; row < row_num; row++) {
            while(row)
            {
            }
            index = row * row_size + 4 * row + 2;
            buffer = &origindata[index];

            for (i = 0; i < row_size;) {
                buffer[i] ^= buffer[i + 1];
                buffer[i + 1] ^= buffer[i];
                buffer[i] ^= buffer[i + 1];
                buffer[i + 2] ^= buffer[i + 3];
                buffer[i + 3] ^= buffer[i + 2];
                buffer[i + 2] ^= buffer[i + 3];
                i += 4;
            }
        }
    } while (0);

    return 0;
}
}

