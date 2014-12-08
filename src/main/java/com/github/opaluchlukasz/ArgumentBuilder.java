package com.github.opaluchlukasz;

import java.util.LinkedHashSet;
import java.util.Set;

public class ArgumentBuilder {

    private Set<String> arguments = new LinkedHashSet<String>();
    //arg-params
    private static final String PORT = "port";
    private static final String BIND_ADDRESS = "bind-address";
    private static final String HTTPS_PORT = "https-port";
    private static final String HTTPS_KEYSTORE = "https-keystore";
    private static final String RECORD_MAPPINGS = "record-mappings";
    private static final String MATCH_HEADERS = "match-headers";
    private static final String PROXY_ALL = "proxy-all";
    private static final String PRESERVE_HOST_HEADER = "preserve-host-header";
    private static final String PROXY_VIA = "proxy-via";
    private static final String VERBOSE = "verbose";
    private static final String ENABLE_BROWSER_PROXYING = "enable-browser-proxying";
    private static final String DISABLE_REQUEST_JOURNAL = "no-request-journal";
    private static final String ROOT_DIR = "root-dir";

    //no-arg params

    public ArgumentBuilder withPort(Integer port) {
        if (port != null) {
            arguments.add(addArgument(PORT));
            arguments.add(String.valueOf(port));
        }
        return this;
    }

    public ArgumentBuilder withHttpsPort(Integer httpsPort) {
        if (httpsPort != null) {
            arguments.add(addArgument(HTTPS_PORT));
            arguments.add(String.valueOf(httpsPort));
        }
        return this;
    }

    public ArgumentBuilder withRootDir(String rootDir) {
        if (rootDir != null) {
            arguments.add(addArgument(ROOT_DIR));
            arguments.add(String.valueOf(rootDir));
        }
        return this;
    }

    public ArgumentBuilder withHttpsKeystore(String httpsKeystore) {
        if (httpsKeystore != null) {
            arguments.add(addArgument(HTTPS_KEYSTORE));
            arguments.add(String.valueOf(httpsKeystore));
        }
        return this;
    }

    public ArgumentBuilder withBindAddress(String bindAddress) {
        if (bindAddress != null) {
            arguments.add(addArgument(BIND_ADDRESS));
            arguments.add(String.valueOf(bindAddress));
        }
        return this;
    }

    public ArgumentBuilder withVerbose(Boolean verbose) {
        if (verbose) {
            arguments.add(addArgument(VERBOSE));
        }
        return this;
    }

    public ArgumentBuilder withPreserveHostHeader(Boolean preserveHostHeader) {
        if (preserveHostHeader) {
            arguments.add(addArgument(PRESERVE_HOST_HEADER));
        }
        return this;
    }

    public ArgumentBuilder withEnableBrowserProxying(Boolean enableBrowserProxying) {
        if (enableBrowserProxying) {
            arguments.add(addArgument(ENABLE_BROWSER_PROXYING));
        }
        return this;
    }

    public ArgumentBuilder withDisableRequestJournal(Boolean disableRequestJournal) {
        if (disableRequestJournal) {
            arguments.add(addArgument(DISABLE_REQUEST_JOURNAL));
        }
        return this;
    }

    public ArgumentBuilder withRecordMappings(Boolean recordMappings) {
        if (recordMappings) {
            arguments.add(addArgument(RECORD_MAPPINGS));
        }
        return this;
    }

    public ArgumentBuilder withMatchHeaders(String matchHeaders) {
        if (matchHeaders != null) {
            arguments.add(addArgument(MATCH_HEADERS));
            arguments.add(String.valueOf(matchHeaders));
        }
        return this;
    }

    public ArgumentBuilder withProxyVia(String proxyVia) {
        if (proxyVia != null) {
            arguments.add(addArgument(PROXY_VIA));
            arguments.add(String.valueOf(proxyVia));
        }
        return this;
    }

    public ArgumentBuilder withProxyAll(String proxyAll) {
        if (proxyAll != null) {
            arguments.add(addArgument(PROXY_ALL));
            arguments.add(String.valueOf(proxyAll));
        }
        return this;
    }

    public String[] build() {
        return arguments.toArray(new String[arguments.size()]);
    }

    private String addArgument(String argument) {
        return "--" + argument;
    }
}
