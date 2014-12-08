package com.github.opaluchlukasz;

import com.github.tomakehurst.wiremock.standalone.WireMockServerRunner;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Mojo that runs wiremock instance with specified parameters.
 *
 */
@Mojo(name = "run")
public class WireMockRunnerMojo extends AbstractMojo {

    private WireMockServerRunner wireMockInstance;

    private final Thread interceptor = new Thread() {

        @Override
        public void run() {
            WireMockRunnerMojo.this.getLog().info("Shouting down WireMock");

            if (WireMockRunnerMojo.this.wireMockInstance.isRunning()) {
                wireMockInstance.stop();
            }
        }
    };

    @Parameter
    private Integer port;
    @Parameter
    private Integer httpsPort;
    @Parameter
    private String rootDir;
    @Parameter
    private String httpsKeystore;
    @Parameter
    private String bindAddress;
    @Parameter
    private Boolean verbose = false;
    @Parameter
    private Boolean recordMappings = false;
    @Parameter
    private Boolean enableBrowserProxying = false;
    @Parameter
    private Boolean disableRequestJournal = false;
    @Parameter
    private Boolean preserveHostHeader = false;
    @Parameter
    private String matchHeaders;
    @Parameter
    private String proxyVia;
    @Parameter
    private String proxyAll;

    @Override
    public void execute() throws MojoExecutionException {
        getLog().info("Starting WireMock");

        wireMockInstance = new WireMockServerRunner();

        wireMockInstance.run(new ArgumentBuilder()
                .withPort(port)
                .withHttpsPort(httpsPort)
                .withRootDir(rootDir)
                .withHttpsKeystore(httpsKeystore)
                .withBindAddress(bindAddress)
                .withVerbose(verbose)
                .withRecordMappings(recordMappings)
                .withMatchHeaders(matchHeaders)
                .withProxyVia(proxyVia)
                .withProxyAll(proxyAll)
                .withEnableBrowserProxying(enableBrowserProxying)
                .withDisableRequestJournal(disableRequestJournal)
                .withPreserveHostHeader(preserveHostHeader)
                .build());

        Runtime.getRuntime().addShutdownHook(interceptor);

        while (true) {

        }

    }

}
