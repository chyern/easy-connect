package chenyudan.domain;

import chenyudan.process.ConnectProcessRouteSpi;
import chenyudan.process.ConnectProcessSpi;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Description: TODO
 *
 * @author chenyu
 * @since 2023/12/13 19:58
 */
@Data
@AllArgsConstructor
public class ConnectConfig {

    private ConnectProcessRouteSpi connectProcessRouteSpi;

    private ConnectProcessSpi connectProcessSpi;
}
