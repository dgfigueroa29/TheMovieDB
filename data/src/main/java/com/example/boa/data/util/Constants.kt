package com.example.boa.data.util

const val BASE_URL = "https://api.themoviedb.org/3/"
const val TOKEN = "7fcad7e227e750d6da6658c90634b7fa"
const val BASE_PARAMS = "?api_key=${TOKEN}&append_to_response=videos"
const val MOVIES_PREFIX = "movie/"
const val TV_PREFIX = "tv/"
const val SEARCH_ENDPOINT = "search/multi"
const val MOVIES_POPULAR_ENDPOINT = "${MOVIES_PREFIX}popular${BASE_PARAMS}"
const val MOVIES_TOP_RATED_ENDPOINT = "${MOVIES_PREFIX}top_rated${BASE_PARAMS}"
const val TV_POPULAR_ENDPOINT = "${TV_PREFIX}popular${BASE_PARAMS}"
const val TV_TOP_RATED_ENDPOINT = "${TV_PREFIX}top_rated${BASE_PARAMS}"
const val IMAGE_URL_PREFIX = "https://image.tmdb.org/t/p/w94_and_h141_bestv2"
const val VIDEO_URL_PREFIX = "https://www.youtube.com/watch?v="