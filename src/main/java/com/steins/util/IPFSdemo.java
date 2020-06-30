package com.steins.util;


import io.ipfs.api.IPFS;
import io.ipfs.api.MerkleNode;
import io.ipfs.api.NamedStreamable.FileWrapper;
import io.ipfs.multiaddr.MultiAddress;
import io.ipfs.multihash.Multihash;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class IPFSdemo {
    public static IPFS ipfs = new IPFS(new MultiAddress("/ip4/127.0.0.1/tcp/5001"));

    public IPFSdemo() {
    }

    public String upload(File file) throws IOException {
        FileWrapper ipfsfile = new FileWrapper(file);
        Multihash addResult = ((MerkleNode)ipfs.add(ipfsfile).get(0)).hash;
        return addResult.toString();
    }

    public void download(File file, String hash) throws IOException {
        Multihash filePointer = Multihash.fromBase58(hash);
        byte[] data = ipfs.cat(filePointer);
        if (data != null) {
            if (file.exists()) {
                file.delete();
            }

            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.flush();
            fos.close();
        }

    }
}