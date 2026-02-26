package com.bhavesh.service;

import com.bhavesh.modal.Asset;
import com.bhavesh.modal.Coin;
import com.bhavesh.modal.User;

import java.util.List;

public interface AssetService {

    Asset createAsset(User user, Coin coin,double quantity);

    Asset getAssetById(Long assetId) throws Exception;

    Asset getAssetByUserIdAndId(Long userId, Long assetId);

    List<Asset> getUserAssets(Long userId);

    Asset updateAsset(Long assetId,double quantity) throws Exception;

    Asset findAssetByUserIdAndCoinId(Long userId,String coinId);

    void deleteAsset(Long assetId);

}
