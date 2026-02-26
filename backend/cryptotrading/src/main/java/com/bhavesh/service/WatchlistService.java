package com.bhavesh.service;

import com.bhavesh.modal.Coin;
import com.bhavesh.modal.User;
import com.bhavesh.modal.Watchlist;

public interface WatchlistService {

    Watchlist findUserWatchlist(Long userId) throws Exception;
    Watchlist createWatchlist(User user);
    Watchlist findById(Long id) throws Exception;

    Coin addItemToWatchlist(Coin coin,User user) throws Exception;
}
