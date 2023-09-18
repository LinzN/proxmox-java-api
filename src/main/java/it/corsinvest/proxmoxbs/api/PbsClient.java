/*
 * SPDX-FileCopyrightText: Copyright Corsinvest Srl
 * SPDX-License-Identifier: GPL-3.0-only
 */
package it.corsinvest.proxmoxbs.api;

import it.corsinvest.proxmoxve.api.Result;
import org.json.JSONException;

/**
 * Proxmox BS Client
 */
public class PbsClient extends PbsClientBase {

    private final PbsClient client;

    public PbsClient(String hostname, int port) {
        super(hostname, port);
        client = this;
    }

    private PBSVersion version;

    public PBSVersion getVersion() {
        return version == null ? (version = new PBSVersion(client)) : version;
    }

    public class PBSVersion {

        private final PbsClient client;

        protected PBSVersion(PbsClient client) {
            this.client = client;

        }

        /**
         * API version details, including some parts of the global datacenter
         * config.
         *
         * @return Result
         * @throws JSONException
         */
        public Result version() throws JSONException {
            return client.get("/version", null);
        }

    }

}
